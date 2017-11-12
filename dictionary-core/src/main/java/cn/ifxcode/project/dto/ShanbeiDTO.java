package cn.ifxcode.project.dto;

import cn.ifxcode.project.constants.DictionaryConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Objects;
import lombok.Data;

import java.util.Map;

/**
 * shanbei return object
 *
 * @author dongbo
 * @date 2017/10/20
 */
@Data
public class ShanbeiDTO {


    /*
    {
        "msg": "SUCCESS",
        "status_code": 0,
        "data": {
            "pronunciations": {
                "uk": "w\u025c\u02d0d",
                "us": "w\u025c\u02d0rd"
             },
             "en_definitions": {
                "v": ["put into words or an expression"],
                "n": ["a unit of language that native speakers can identify", "a brief statement", "information about recent and important events"]
              },
              "audio_addresses": {
                "uk": ["https://media-audio1.baydn.com/uk%2Fw%2Fwo%2Fword_v3.mp3", "http://media-audio1.qiniu.baydn.com/uk/w/wo/word_v3.mp3"],
                "us": ["https://media-audio1.baydn.com/us%2Fw%2Fwo%2Fword_v3.mp3", "http://media-audio1.qiniu.baydn.com/us/w/wo/word_v3.mp3"]
              },
              "uk_audio": "http://media.shanbay.com/audio/uk/word.mp3",
              "conent_id": 312,
              "audio_name": "word_v3",
              "cn_definition": {
                "pos": "",
                "defn": "n. \u8bcd, \u5355\u8bcd, \u6d88\u606f, \u8bfa\u8a00\nvt. \u7528\u8bcd\u8bed\u8868\u8fbe"
              },
              "num_sense": 1,
              "content_id": 312,
              "content_type": "vocabulary",
              "sense_id": 0,
              "id": 312,
              "definition": " n. \u8bcd, \u5355\u8bcd, \u6d88\u606f, \u8bfa\u8a00\nvt. \u7528\u8bcd\u8bed\u8868\u8fbe",
              "has_collins_defn": true,
              "url": "https://www.shanbay.com/bdc/mobile/preview/word?word=word",
              "has_audio": true,
              "en_definition": {
                "pos": "v",
                "defn": "put into words or an expression"
              },
              "object_id": 312,
              "content": "word",
              "pron": "w\u025c\u02d0rd",
              "pronunciation": "w\u025c\u02d0rd",
              "audio": "http://media.shanbay.com/audio/us/word.mp3",
              "us_audio": "http://media.shanbay.com/audio/us/word.mp3"
          }
     }
     */
    private Long content_id;
    private String content;
    private String url;
    private int retention;
    private boolean has_audio;
    private String audio_name;
    private String audio;
    private String us_audio;
    private String uk_audio;
    private Map<String, String> pronunciations;
    private String us_pron;
    private String uk_pron;
    private Map<String, String[]> en_definitions;
    private Map<String, String> en_definition;
    private Map<String, String> cn_definition;
    private String definition;

    public String getUs_pron() {
        if (pronunciations != null) {
            return pronunciations.get("us");
        }
        return null;
    }

    public String getUk_pron() {
        if (pronunciations != null) {
            return pronunciations.get("uk");
        }
        return null;
    }

    public static ShanbeiDTO fromJSON(String json) {
        JSONObject object = JSON.parseObject(json);
        if (object.containsKey(DictionaryConstants.MSG)
                && Objects.equal(DictionaryConstants.SUCCESS, object.getString(DictionaryConstants.MSG))
                && object.containsKey(DictionaryConstants.STATUS_CODE)
                && object.getIntValue(DictionaryConstants.STATUS_CODE) == 0) {
            return object.getObject(DictionaryConstants.DATA, ShanbeiDTO.class);
        }
        return null;
    }

    public static void main(String[] args) {
        String json = "{\"msg\": \"SUCCESS\", \"status_code\": 0, \"data\": {\"pronunciations\": {\"uk\": \"'\\u026a\\u014b\\u0261l\\u026a\\u0283\", \"us\": \"'\\u026a\\u014b\\u0261l\\u026a\\u0283\"}, \"en_definitions\": {\"adj\": [\"of or relating to or characteristic of England or its culture or people\", \"of or relating to the English language\"], \"n\": [\"an Indo-European language belonging to the West Germanic branch; the official language of Britain and the United States and most of the commonwealth countries\", \"the people of England\", \"the discipline that studies the English language and literature\"]}, \"audio_addresses\": {\"uk\": [\"https://media-audio1.baydn.com/uk%2Fe%2Fen%2Fenglish_v3.mp3\", \"http://media-audio1.qiniu.baydn.com/uk/e/en/english_v3.mp3\"], \"us\": [\"https://media-audio1.baydn.com/us%2Fe%2Fen%2Fenglish_v3.mp3\", \"http://media-audio1.qiniu.baydn.com/us/e/en/english_v3.mp3\"]}, \"uk_audio\": \"http://media.shanbay.com/audio/uk/english.mp3\", \"conent_id\": 2376, \"audio_name\": \"english_v3\", \"cn_definition\": {\"pos\": \"\", \"defn\": \"n.\\u82f1\\u8bed\\nadj.\\u82f1\\u683c\\u5170\\u7684\\uff1b \\u82f1\\u56fd\\u7684\\uff1b \\u82f1\\u8bed\\u7684\\uff1b \\u82f1\\u683c\\u5170\\u4eba\\u7684\"}, \"num_sense\": 1, \"content_id\": 2376, \"content_type\": \"vocabulary\", \"sense_id\": 0, \"id\": 2376, \"definition\": \" n.\\u82f1\\u8bed\\nadj.\\u82f1\\u683c\\u5170\\u7684\\uff1b \\u82f1\\u56fd\\u7684\\uff1b \\u82f1\\u8bed\\u7684\\uff1b \\u82f1\\u683c\\u5170\\u4eba\\u7684\", \"has_collins_defn\": true, \"url\": \"https://www.shanbay.com/bdc/mobile/preview/word?word=English\", \"has_audio\": true, \"en_definition\": {\"pos\": \"adj\", \"defn\": \"of or relating to or characteristic of England or its culture or people; of or relating to the English language\"}, \"object_id\": 2376, \"content\": \"English\", \"pron\": \"'\\u026a\\u014b\\u0261l\\u026a\\u0283\", \"pronunciation\": \"'\\u026a\\u014b\\u0261l\\u026a\\u0283\", \"audio\": \"http://media.shanbay.com/audio/us/English.mp3\", \"us_audio\": \"http://media.shanbay.com/audio/us/english.mp3\"}}";
        ShanbeiDTO shanbeiDTO = ShanbeiDTO.fromJSON(json);
        System.out.println(shanbeiDTO.toString());
    }
}
