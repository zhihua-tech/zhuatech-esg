/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.esg.service;

import jakarta.validation.constraints.*;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarbonPathService {
    public Result evaluate(Request r) {
        double targetEmission = r.baselineEmission() * (1 - r.targetReductionPercent() / 100.0);
        double reduction = (r.baselineEmission() - r.currentEmission()) / r.baselineEmission() * 100;
        double baselineIntensity = r.baselineEmission() / r.baselineRevenue();
        double currentIntensity = r.currentEmission() / r.currentRevenue();
        double intensityReduction = (baselineIntensity - currentIntensity) / baselineIntensity * 100;
        double gap = Math.max(0, r.currentEmission() - targetEmission);
        int years = Math.max(1, r.targetYear() - r.currentYear());
        double annualReduction = gap / years;
        double annualRate = annualReduction / r.currentEmission() * 100;
        String status = gap == 0 ? "ACHIEVED" : annualRate > 8 || r.renewableEnergyPercent() < 30 ? "ACCELERATE" : "ON_TRACK";
        List<String> actions = new ArrayList<>();
        if (annualRate > 8) actions.add("年度减排压力较高，需拆分重点排放源行动计划");
        if (r.renewableEnergyPercent() < 30) actions.add("提升可再生能源采购与自建能源占比");
        if (intensityReduction < reduction) actions.add("关注业务增长对单位收入排放强度的影响");
        return new Result(scale(targetEmission), scale(reduction), scale(intensityReduction), scale(gap),
            scale(annualReduction), scale(annualRate), status, actions);
    }
    private double scale(double value) { return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue(); }
    public record Request(@Positive double baselineEmission, @PositiveOrZero double currentEmission,
        @Positive double baselineRevenue, @Positive double currentRevenue,
        @DecimalMin("0") @DecimalMax("100") double targetReductionPercent,
        @DecimalMin("0") @DecimalMax("100") double renewableEnergyPercent,
        @Min(2000) int currentYear, @Min(2001) int targetYear) {}
    public record Result(double targetEmission, double achievedReductionPercent, double intensityReductionPercent,
        double targetGap, double requiredAnnualReduction, double requiredAnnualReductionPercent,
        String status, List<String> actions) {}
}

