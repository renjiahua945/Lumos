package club.javafan.blog.common.sennsor;

import com.baidu.aip.contentcensor.AipContentCensor;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 *  文本审核单例
 */
@Component
public class AipContentCensorBuilder {
    private static final Logger logger = LoggerFactory.getLogger(AipContentCensorBuilder.class);


    private static AipContentCensor client = new AipContentCensor ("18131202", "T1TAQcoANVtGgibseCATCblY", "HmgAhWXV3Ao1GRHtBsqKI4PAswlQzMim");

    public static AipContentCensor getInstance() {
        return client;
    }

    private AipContentCensorBuilder() {

    }
    public static class SensorResult{
        private String desc;
        private Integer code;

        public String getDesc() {
            return desc;
        }

        public SensorResult setDesc(String desc) {
            this.desc = desc;
            return this;
        }

        public Integer getCode() {
            return code;
        }

        public SensorResult setCode(Integer code) {
            this.code = code;
            return this;
        }
        public SensorResult failResult(String desc){
            SensorResult sensorResult = new SensorResult();
            sensorResult.setCode(1);
            sensorResult.setDesc(desc);
            return sensorResult;
        }

        public SensorResult successResult(String desc) {
            SensorResult sensorResult = new SensorResult();
            sensorResult.setCode(0);
            sensorResult.setDesc(desc);
            return sensorResult;
        }
    }
    public static SensorResult judgeText(String text){
        JSONObject jsonObject = client.antiSpam(text, null);
        logger.info("AipContentCensorBuilder text: {},info: {}",text,jsonObject);
        //0表示非违禁，1表示违禁，2表示建议人工复审
        JSONObject result = jsonObject.getJSONObject("result");
        if (Objects.isNull(jsonObject) || Objects.isNull(result)|| result.getInt("spam") == 0){
            return new SensorResult().successResult("需要人工审核");
        }
        return new SensorResult().failResult("失败！");

    }
}
