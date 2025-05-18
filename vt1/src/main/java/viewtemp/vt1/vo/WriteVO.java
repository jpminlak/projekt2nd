package viewtemp.vt1.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class WriteVO {

    @Getter
    @Setter
    private String ID;
    private String name;
    private String writer;
    private String title;
    private String content;
    private int writeview = 0;
    private List<String> files;

    private String reply;
    private List<String> replies;

    private String board;
    private String accident;
    private String law;
    private String insurance;
    private boolean answer;
}
