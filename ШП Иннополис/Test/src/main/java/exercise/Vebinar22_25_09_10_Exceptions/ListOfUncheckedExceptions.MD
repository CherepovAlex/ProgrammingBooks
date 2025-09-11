# Список не проверяемых системных исключений

ArithmeticException - арифметическая ошибка, например, деление на ноль
ArrayIndexOutOfBoundsException - выход индекса за границы массива
ArrayStoreException - присваивание элементу массива объекта несовместимого типа
ClassCastException - неверное приведение типа
EnumConstantNotPresentException - попытка использования неопределенного значения перечисления
IllegalArgumentException - неверный аргумент при вызове метода
IllegalMonitorStateException - неверная операция мониторинга
IllegalStateException - некорректное состояние приложения
IllegalThreadStateException - запрашиваемая операция несовместима с текущим потоком

IndexOutOfBoundsException - выход индекса за допустимые пределы
NegativeArraySizeException - создание массива отрицательного размера
NullPointerException - некорректное использование пустой ссылки (null)
NumberFormatException - неверное преобразование строки в числовой формат
SecurityException - попытка нарушения безопасности
StringIndexOutOfBoundsException - использование индекса за пределами строки
TypeNotFoundException - тип не найден
UnsupportedOperationException - обнаружена неподдерживаемая операция

# Методы класса Throwable

final void addSuppressed(Throwable exception) - добавляет исключение в список подавляемых исключений (JDK 7)
Throwable fillInStackTrace() - возвращает объект класса Throwable, содержащий полную трассировку стека
Throwable getCause() - возвращает исключение, лежащее в основе текущего исключения, или null
String getLocalizedMessage() - возвращает локализованное описание исключения
StackTraceElement[] getStackTrace() - возвращает массив, содержащий трассировку стека, состоящий из элементов класса StackTraceElement
final Throwable[] getSuppressed() - получает подавленные исключения (JDK 7)
Throwable initCause(Throwable exception) - ассоциирует исключение с вызывающим исключением. Возвращает ссылку на исключение.

void printStackTrace() - выводит трассировку стека, которая содержит информацию для определения причины исключения и места его возникновения
void printStackTrace(PrintWriter stream) - отправляет трассировку стека в указанный поток
void setStackTrace(StackTraceElement[] elements) - устанавливает трассировку стека из элементов (для специализированных приложений)
String toString() - возвращает название класса и текст ошибки
String getMessage() - возвращает текст ошибки
* - для вывода ошибок можно использовать отдельный поток (System.err)

