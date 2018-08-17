package spring_small_backend;

import lombok.Data;

@Data
class Response{
    boolean result;

    Response(boolean result) {
        this.result = result;
    }
}