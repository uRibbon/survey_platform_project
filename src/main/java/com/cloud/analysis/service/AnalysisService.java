package com.cloud.analysis.service;

import com.cloud.analysis.entity.Analysis_option;

import java.util.List;

public interface AnalysisService {
    List<Analysis_option> getAnalysisList(Integer surId);
}
