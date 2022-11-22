package com.cloud.survey.service;

import com.cloud.survey.dto.PageRequestDTO;
import com.cloud.survey.dto.PageResultDTO;
import com.cloud.survey.dto.survey.SurveyCategoryDTO;
import com.cloud.survey.entity.SurveyCategory;
import com.cloud.survey.repository.SurveyCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class SurveyCategoryServiceImpl implements SurveyCategoryService {
    @Autowired
    private final SurveyCategoryRepository surveyCategoryRepository;

    @Override
    public PageResultDTO<SurveyCategoryDTO, SurveyCategory> getCategoryList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("regDt").descending());
        Page<SurveyCategory> surveyCategoryPage = surveyCategoryRepository.findAll(pageable);
        Function<SurveyCategory, SurveyCategoryDTO> fn = (surveyCategory -> entityToDTO(surveyCategory));
        return new PageResultDTO<>(surveyCategoryPage, fn);
    }

    @Override
    public void insertCategory(SurveyCategoryDTO surveyCategoryDTO) {
        surveyCategoryRepository.save(dtoToEntity(surveyCategoryDTO));
    }

    @Override
    public void deleteCategory(Integer surCatId) {
        surveyCategoryRepository.deleteById(surCatId);
    }
}
