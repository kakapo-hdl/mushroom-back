package com.mushroom.mgjstreet.entity;

import com.mushroom.mgjstreet;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author totolo
 * @since 2021-02-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryKey extends mgjstreet {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer categoryId;

    private String name;

    private Boolean isSpec;

    private LocalDateTime createDate;

    private LocalDateTime upadteDate;


}
