package com.xy.my_retrofit_rxjava2_task.network.model.request;

import com.okay.teachertasklib.network.model.base.RequestBase;

import java.util.ArrayList;
import java.util.List;

/**
 * desc RequestRectifyAll
 * <p>
 * Created on 18/1/8.
 * author: zhangpanzhao
 */

public class RequestRectifyAll extends RequestBase {
    public int bus_type;                    // 1：按人 2：按题
    public String link_id;                  // link_id
    public String publish_id;               // 发布id
    public String question_id;              // 题目id（大题）
    public String resource_id;              // 资源id
    public String result;                   // 批改结果 1/对，2/错，5/半对。必填
    public String scene_type;               // 6作业 7 测评 8 预习。必填
    public List<Long> student_id;   // 学生id

    public List<SubmitAnswer> answer = new ArrayList<>();

    public List<Score> q_scores;

    public static class Score {
        public Long q_id;
        public float q_score;

        @Override
        public boolean equals(Object o) {

            if (!(o instanceof Score)) return false;

            Score score = (Score) o;
            return this.q_id.longValue() == score.q_id.longValue()
                    && this.q_score == score.q_score;
        }
    }
}
