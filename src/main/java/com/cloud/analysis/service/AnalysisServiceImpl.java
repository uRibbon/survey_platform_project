package com.cloud.analysis.service;

import com.cloud.analysis.entity.Survey_analysis_option;
import com.cloud.analysis.repository.AnalysisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalysisServiceImpl implements AnalysisService {
    @Autowired
    private final AnalysisRepository analysisRepository;

    @Override
    public List<Survey_analysis_option> getAnalysisList(Integer analysisId) {
        List<Object> AllAnalysisList = new ArrayList<>();
        List<Survey_analysis_option> analysisList = analysisRepository.findAnalysisByColumn(analysisId);
        return analysisList;
    }


}
