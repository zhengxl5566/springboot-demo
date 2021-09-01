package com.javahelper.top.transactional.exception;

/**
 * @description:
 * @projectName:transactional
 * @see:com.javahelper.top.transactional.exception
 * @author:郑晓龙
 * @createTime:2021/8/23 15:05
 * @version:1.0
 */
public class RollBackException extends Exception {
    public RollBackException(String message) {
        super(message);
    }
}
