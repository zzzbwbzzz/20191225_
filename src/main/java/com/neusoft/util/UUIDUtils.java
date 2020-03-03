package com.neusoft.util;

import java.util.UUID;

/**
 * * <b>Description:</b><br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> 20191225_ <br>
 *       <b>PackageName:</b> com.neusoft.util <br>
 *       <b>ClassName:</b> UUIDUtils <br>
 *       <b>Date:</b> 2020年1月5日 上午11:11:39
 */
public class UUIDUtils {

    public static String getUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString();
    }
}
