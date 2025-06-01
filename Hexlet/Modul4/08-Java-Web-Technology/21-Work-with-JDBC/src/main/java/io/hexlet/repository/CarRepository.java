package io.hexlet.repository;

import io.hexlet.model.Car;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

public class CarRepository extends BaseRepository {
    //Вставляет данные об автомобиле (make, model) в таблицу cars.
    //Получает сгенерированный БД id и сохраняет его в объект Car.
    public static void save(Car car) throws SQLException {
        //SQL-запрос для вставки данных в таблицу cars.
        //? — параметры, которые заменяются значениями позже (защита от SQL-инъекций)
        String sql = "INSERT INTO cars (make, model) VALUES (?, ?)";
        //Получает соединение из пула (dataSource).
        //Создает PreparedStatement с флагом RETURN_GENERATED_KEYS (чтобы получить сгенерированный БД id).
        //try-with-resources автоматически закрывает соединение и стейтмент после выполнения.
        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            //Устанавливает значения параметров в запросе:
            //1 — марка автомобиля (make).
            //2 — модель автомобиля (model).
            preparedStatement.setString(1, car.getMake());
            preparedStatement.setString(2, car.getModel());
            //Выполняет SQL-запрос и возвращает количество измененных строк.
            preparedStatement.executeUpdate();
            //Получает сгенерированные БД ключи (в данном случае — id новой записи).
            var generatedKeys = preparedStatement.getGeneratedKeys();
            // Устанавливаем ID в сохранённую сущность
            //Если ключ получен — устанавливает id в объект Car
            //Если нет — выбрасывает исключение (ошибка сохранения)
            if (generatedKeys.next()) {
                car.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    //Возвращает Optional<Car> в БД по указанному идентификатору
    //(может содержать найденный автомобиль или быть пустым)
    public static Optional<Car> find(Long id) throws SQLException {
        // Создание SQL-запроса для выборки автомобиля по идентификатору
        //? - параметр, который будет заменен позже (защита от SQL-инъекций)
        var sql = "SELECT * FROM cars WHERE id = ?";
        // получение соединения с БД из пула соединений (dataSource)
        // создание подготовленного выражения (PreparedStatement)
        // использование try-with-resources для автоматического закрытия ресурсов
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            // Установка значения параметра в SQL-запросе (подстановка id вместо ?)
            stmt.setLong(1, id);
            // Выполнение SQL-запроса и получение результата в виде ResultSet
            var resultSet = stmt.executeQuery();
            // Проверка наличия результатов запроса (переход к первой записи)
            if (resultSet.next()) {
                // Получение значения столбца "make" из результата запроса
                var make = resultSet.getString("make");
                // Получение значения столбца "model" из результата запроса
                var model = resultSet.getString("model");
                // Создание нового объекта Car с полученными значениями
                var car = new Car(make, model);
                // Установка идентификатора для созданного объекта автомобиля
                car.setId(id);
                // Возврат найденного автомобиля, обернутого в Optional
                return Optional.of(car);
            }
            // Возврат пустого Optional, если автомобиль не найден
            return Optional.empty();
        }
    }

    // Возвращает список автомобилей (List<Car>), каждая строка БД преобразуется в объект Car
    // Возвращаемый тип - List<Car> вместо Optional, так как список может быть пустым
    public static List<Car> getEntities() throws SQLException {
        // SQL-запрос для выборки всех записей из таблицы cars
        var sql = "SELECT * FROM cars";
        // Получение соединения из пула (dataSource)
        //Создание подготовленного выражения (PreparedStatement)
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            // Выполнение запроса и получение результатов в виде ResultSet
            var resultSet = stmt.executeQuery();
            // Создание пустого списка для хранения результатов
            var result = new ArrayList<Car>();
            // Цикл по всем строкам результата запроса
            while (resultSet.next()) {
                // Получение значения столбца id, make, model для текущей строки
                var id = resultSet.getLong("id");
                var make = resultSet.getString("make");
                var model = resultSet.getString("model");
                // Создание нового объекта Car с полученными значениями марки и модели
                var car = new Car(make, model);
                // Установка идентификатора для созданного автомобиля
                car.setId(id);
                // Добавление автомобиля в результирующий список
                result.add(car);
            }
            return result;
        }
    }
}
