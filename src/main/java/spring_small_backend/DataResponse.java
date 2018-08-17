package spring_small_backend;

import lombok.Data;

@Data
class DataResponse<T> extends Response{

    DataResponse(boolean result, T data) {
        super(result);
        this.data = data;
    }

    T data;
}