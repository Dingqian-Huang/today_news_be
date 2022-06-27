package com.david.commom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse<T> implements Serializable {
    //current page
    private Long page;
    //page size
    private Long size;
    //total data number
    private Long total;
    //total page number
    private Long totalPages;
    //current page data
    private List<T> list;

}
