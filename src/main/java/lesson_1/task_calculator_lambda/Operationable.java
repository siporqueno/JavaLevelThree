package lesson_1.task_calculator_lambda;

@FunctionalInterface
public interface Operationable<T> {
    T calculate(T x, T y);
}
