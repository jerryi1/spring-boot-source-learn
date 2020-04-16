package com.lhq.boot.demo.databind_validate;

import lombok.Data;

@Data
public class House {
    /**
     * 房子的风格
     */
    private String style;

    /**
     * 房子的主人
     */
    private Person person;
}
