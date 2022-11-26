package deb.practice.javaspring.completablefuture.service;

import deb.practice.javaspring.completablefuture.model.CompletableFutureModel;

import java.util.concurrent.ExecutionException;

public interface CompletableFutureService {

    CompletableFutureModel computation() throws ExecutionException, InterruptedException;
    CompletableFutureModel multipleFuture() throws ExecutionException, InterruptedException;
    CompletableFutureModel returningValueBeforeComplete() throws ExecutionException, InterruptedException;
    CompletableFutureModel exception();
}
