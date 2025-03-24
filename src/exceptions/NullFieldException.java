package exceptions;

/**
 * Класс, представляющий ошибку: Поле является null
 */
public class NullFieldException extends RuntimeException {
    /**
     * Конструктор NullFieldException
     * @param message сообщение об ошибке
     */
    public NullFieldException(String message) {
        super(message);
    }
}
