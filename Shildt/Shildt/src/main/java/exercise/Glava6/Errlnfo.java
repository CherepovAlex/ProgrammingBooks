package exercise.Glava6;

// Возврат объекта, определяемого разработчиком программы,
class Err {
    String msg; // Сообщение об ошибке
    int severity; // Код, определяющий серьезность ошибки

    Err(String m, int s) {
        msg = m;
        severity = s;
    }
}

class Errorlnfo {
    String msgs[] = {
        "Output Error",
        "Input Error",
        "Disk Full",
        "Index Out-Of-Bounds"
    };
    int howbad[] = { 3, 3, 2, 4 };

    // Возврат объекта типа Err.
    Err getErrorInfo(int i) {
        if(i >=0 & i < msgs.length)
            return new Err(msgs[i], howbad[i]);
        else
            return new Err("Invalid Error Code", 0) ;
    }
}

public class Errlnfo {
    public static void main(String args[]) {
        Errorlnfo err = new Errorlnfo();
        Err e;

        e = err.getErrorInfo(2);
        System.out.println(e.msg + " severity: " + e.severity);

        e = err.getErrorInfo(19) ;
        System.out.println(e.msg + " severity: " + e.severity);
    }
}