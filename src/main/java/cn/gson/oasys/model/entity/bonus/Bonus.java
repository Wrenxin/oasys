package cn.gson.oasys.model.entity.bonus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 万先生
 * 2019/3/2  21:23
 */
@Entity
@Table(name = "w_bonus")
public class Bonus {
    @Id
    @Column(name = "bonus_id")
    private Integer bonusId;

    @Column(name = "bonus_content")
    private String bonusContent;

    @Column(name = "bonus_time")
    private String bonusTime;

    public Integer getBonusId() {
        return bonusId;
    }

    public void setBonusId(Integer bonusId) {
        this.bonusId = bonusId;
    }

    public String getBonusContent() {
        return bonusContent;
    }

    public void setBonusContent(String bonusContent) {
        this.bonusContent = bonusContent;
    }

    public String getBonusTime() {
        return bonusTime;
    }

    public void setBonusTime(String bonusTime) {
        this.bonusTime = bonusTime;
    }
}
