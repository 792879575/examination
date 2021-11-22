package com.exam.entity;

import com.exam.vo.AnswerVO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Score {
    private Integer examCode;

    private Integer studentId;

    private String subject;

    private Integer ptScore;

    private Integer etScore;

    private Integer score;

    private Integer scoreId;

    private String answerDate;

    private List<AnswerVO> answerVOS;
}