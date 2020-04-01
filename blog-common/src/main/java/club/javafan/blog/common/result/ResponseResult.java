package club.javafan.blog.common.result;

import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ONE;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;

/**
 * @author 敲代码的长腿毛欧巴(博客)
 * @date 2019/12/8 14:29
 * @desc 返回结果类
 */
public class ResponseResult<T> {
    /**
     * 返回结果描述
     */
    private String desc;
    /**
     * 返回结果状态码 0-成功 -1-失败
     */
    private Integer code;
    /**
     *  返回结果数据
     */
    private T data;

    public ResponseResult(String desc, Integer code) {
        this.desc = desc;
        this.code = code;
    }

    public ResponseResult() {
    }
    public ResponseResult(Integer code) {
        this.code = code;
    }

    public ResponseResult(String desc, Integer code, T data) {
        this.desc = desc;
        this.code = code;
        this.data = data;
    }

    /**
     * 生成失败的返回值
     *
     * @param desc
     * @return
     */
    public static ResponseResult failResult(String desc) {
        return new ResponseResult(desc, ResponseResultEnum.FAIL.code);
    }
    /**
     * 生成成功的返回值
     *
     * @param desc
     * @return
     */
    public static ResponseResult successResult(String desc) {
        return new ResponseResult(desc, ResponseResultEnum.SUCCESS.code);
    }
    public static ResponseResult successResult() {
        return new ResponseResult(ResponseResultEnum.SUCCESS.code);
    }

    protected enum ResponseResultEnum {
        /**
         * 返回结果成功
         */
        SUCCESS(INTEGER_ZERO),
        /**
         * 返回结果失败
         */
        FAIL(INTEGER_ONE);

        public Integer getCode() {
            return code;
        }

        /**
         * 状态码
         */
        Integer code;

        ResponseResultEnum(Integer code) {
            this.code = code;
        }
    }

    public String getDesc() {
        return desc;
    }

    public ResponseResult<T> setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public ResponseResult<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseResult<T> setData(T data) {
        this.data = data;
        return this;
    }
    public boolean isSuccess(){
        return ResponseResultEnum.SUCCESS.getCode().equals(this.code);
    }
}