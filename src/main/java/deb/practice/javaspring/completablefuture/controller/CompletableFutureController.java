package deb.practice.javaspring.completablefuture.controller;

import deb.practice.javaspring.completablefuture.model.CompletableFutureModel;
import deb.practice.javaspring.completablefuture.service.CompletableFutureService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/future")
public class CompletableFutureController {
    private final CompletableFutureService service;

    public CompletableFutureController(@Qualifier("completableFuture") CompletableFutureService service) {
        this.service = service;
    }

    @GetMapping("/compute")
    public CompletableFutureModel computation() throws ExecutionException, InterruptedException {
        return this.service.computation();
    }

    @GetMapping("/multiple")
    public CompletableFutureModel multiple() throws ExecutionException, InterruptedException {
        return this.service.multipleFuture();
    }

    @GetMapping("/return")
    public CompletableFutureModel returningValueBeforeComplete() throws ExecutionException, InterruptedException {
        return this.service.returningValueBeforeComplete();
    }

    @GetMapping("/exception")
    public CompletableFutureModel exception() {
        return this.service.exception();
    }
}
