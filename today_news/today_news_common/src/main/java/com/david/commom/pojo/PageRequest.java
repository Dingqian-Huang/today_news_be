package com.david.commom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequest<T> implements Serializable {
    //current page number, default 1
    private Long page = 1L;
    //page size, default 10
    private Long size = 10L;
    //request body
    private T body;
}
