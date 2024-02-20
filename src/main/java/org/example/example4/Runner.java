package org.example.example4;

import java.util.concurrent.*;

public class Runner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // МНОГОПОТОЧНАЯ ЗАДАЧА В ВИДЕ Runnable
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());

        // МНОГОПОТОЧНАЯ ЗАДАЧА В ВИДЕ Callable
        StringBuffer stringBuffer = new StringBuffer();
        Callable<StringBuffer> callable = () -> {
            for (int i = 0; i < 50; i++) {
                stringBuffer.append(i);
            }
            return stringBuffer;
        };

        // ExecutorService НА 8 (ФИКСИРОВАННОЕ КОЛ-ВО) ПОТОКОВ
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        // ExecutorService ВЫПОЛНЯЕТ ЗАДАЧУ В ВИДЕ Runnable
        executorService.submit(runnable);

        // ExecutorService ВЫПОЛНЯЕТ ЗАДАЧУ В ВИДЕ Callable И ВОЗВРАЩАЕТ ЗНАЧЕНИЕ ОБЕРНУТОЕ ВО Future
        Future<StringBuffer> submit = executorService.submit(callable);
        // ИЗ ОБЕРТКИ (Future) ДОСТАЕМ ФАКТИЧЕСКОЕ ВОЗВРАЩАЕМОЕ ДАННОЕ
        System.out.println(submit.get());

        // ЗАВЕРШАЕМ РАБОТУ ПУЛА ПОТОКОВ
        executorService.shutdown();
    }
}
