package com.springboot.childRESTFulAPI.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildResponse {

    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
    private List<ChildDTO> content;

}
