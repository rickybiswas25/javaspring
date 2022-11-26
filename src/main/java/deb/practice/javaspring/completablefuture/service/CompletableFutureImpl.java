package deb.practice.javaspring.completablefuture.service;

import deb.practice.javaspring.completablefuture.model.CompletableFutureModel;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Service("completableFuture")
public class CompletableFutureImpl implements CompletableFutureService {
    private static final String SAMPLE_STRING = null;
    @Override
    public CompletableFutureModel computation() throws ExecutionException, InterruptedException {
        CompletableFuture<CompletableFutureModel> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Executing completable future.. starting sleeping for 5 second");
            return new CompletableFutureModel(1, "Rick");
        });
        completableFuture.thenApply(e1 -> {
            System.out.println("Executing completable future.. starting sleeping for 10 second");
            System.out.println("Sleep finished modifying and returning value");
            return new CompletableFutureModel(e1.id() + 1, e1.name() + "y");
        });
        return completableFuture.get();
    }

    @Override
    public CompletableFutureModel multipleFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<CompletableFutureModel> future1
                = CompletableFuture.supplyAsync(() -> {
            sleep(5L);
            return new CompletableFutureModel(1, "Ric");
        });
        CompletableFuture<CompletableFutureModel> future2
                = CompletableFuture.supplyAsync(() -> {
            sleep(2L);
            return new CompletableFutureModel(1, "k");
        });
        CompletableFuture<CompletableFutureModel> future3
                = CompletableFuture.supplyAsync(() -> {
            sleep(4L);
            return new CompletableFutureModel(1, "k");
        });
        System.out.println("Outside of future");
        System.out.println("Printing 1---------" + future1.get());
        System.out.println("Printing 2---------" + future2.get());
        System.out.println("Printing 3---------" + future3.get());
        return new CompletableFutureModel(1, "success");
    }

    @Override
    public CompletableFutureModel returningValueBeforeComplete() throws ExecutionException, InterruptedException {
        CompletableFuture<CompletableFutureModel> future1
                = CompletableFuture.supplyAsync(() -> {
            sleep(5L);
            return new CompletableFutureModel(1, "Ric");
        });
        CompletableFuture<CompletableFutureModel> future2
                = CompletableFuture.supplyAsync(() -> {
            sleep(10L);
            return new CompletableFutureModel(1, "Ric");
        });
        CompletableFuture<Void> combineFuture = CompletableFuture.allOf(future1, future2);
        System.out.println(future1.isDone());
        System.out.println(future2.isDone());
        combineFuture.get();
        System.out.println();
        return new CompletableFutureModel(1, "success");
    }

    @Override
    public CompletableFutureModel exception() {
        CompletableFuture<CompletableFutureModel> future1
                = CompletableFuture.supplyAsync(() -> {
            if (SAMPLE_STRING == null) {
                throw new RuntimeException("Error occurred");
            }
            System.out.println("Returning value");
            return new CompletableFutureModel(1, "Ric");
        });
        CompletableFuture<CompletableFutureModel> future2
                = CompletableFuture.supplyAsync(() -> {
            sleep(10L);
            return new CompletableFutureModel(1, "Ric");
        });

        return new CompletableFutureModel(1, "success");
    }

    private void sleep(long time) {
        System.out.println("Sleeping for " + time);
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Sleep completed");
    }
}
