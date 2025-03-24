package exceptions;

/**
 * Класс, представляющий ошибку: Поле больше, чем константа
 */
public class FieldMoreThanConstantException extends RuntimeException {
    /**
     * Конструктор класса FieldMoreThanConstantException
     * @param message сообщение о самой ошибке
     */
    public FieldMoreThanConstantException(String message) {
        super(message);
    }
}
