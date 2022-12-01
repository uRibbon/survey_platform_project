import { createAction, handleActions } from 'redux-actions';
import createRequestSaga, { createRequestActionTypes} from '../lib/createRequestSaga';
import { delay, put, takeLatest, select, throttle } from 'redux-saga/effects';
import {Map, List} from 'immutable';
import { _ } from 'core-js';

const ADD_QUESTION = 'question/add';
const DELETE_QUESTION = 'question/delete';
const EDIT_QUESTION_CONTENT = 'question/edit_question_content';

export const addQuestion = createAction(ADD_QUESTION);
export const deleteQuestion = createAction(DELETE_QUESTION);
export const editQuestionContent = createAction(EDIT_QUESTION_CONTENT, ({ id, value, name }) => ({
    id, value, name
  }));


export function* questionSaga() {
//   takeEvery 는 들어오는 모든 액션에 대하여 특정 작업을 처리해줍니다.
//   yield takeEvery(INCREASE_ASYNC, increaseSaga);
//   첫번째 파라미터: n초 * 1000
//   yield throttle(3000, INCREASE_ASYNC, increaseSaga);
//   takeLatest 는 만약 기존에 진행중이던 작업이 있다면 취소처리 하고
//   가장 마지막으로 실행된 작업만을 수행합니다.
//   yield takeLatest(DECREASE_ASYNC, decreaseSaga);
}

const initialState = 
List([
    Map({
        id : 1,
        questionType : "Sub",
        content : "테스트",
        optionList : []
    }),
    Map({
        id : 2,
        questionType : "NumOnly",
        content : "테스트",
        optionList : [
            {
            queOptId : 1,
            optionName : "test"
            }, 
            {
            queOptId : 2,
            optionName : "test"
            }
        ]
    })
  ]);


const questions = handleActions({

    [ADD_QUESTION] : (state, action) => { //질문추가
        const id  = action.payload;

        return state.push(Map({
                id : id,
                questionType : "NumOnly",
                content : "테스트",
                optionList : [{
                    queOptId : 1,
                    optionName : "test1"
                    }, {
                    queOptId : 2,
                    optionName : "test2"
                }]
            }));
    },

    [DELETE_QUESTION]: (state, { payload: question }) => { //질문삭제
        return state.filter(function(data) {
            return data.get("id") !== question.id;
        });
    },

    [EDIT_QUESTION_CONTENT] : (state, {payload: question }) => {
        const text = question.value;

        return state.map(function(data) {
            if (data.get("id") == question.id){
                return data.set("content", text);
            }else{
                return data;
            }
        });
    },

  },
  initialState
);

export default questions;