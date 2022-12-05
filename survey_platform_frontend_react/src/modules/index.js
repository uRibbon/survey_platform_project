import { combineReducers } from 'redux';
import { all } from 'redux-saga/effects';
import auth, { authSaga } from './auth';
import loading from './loading';
import user, { userSaga } from './user';
import questions, { questionSaga } from './questions';
import survey, { surveySaga } from './survey';

const rootReducer = combineReducers({
  auth,
  loading,
  user,
  questions,
  survey
});

export function* rootSaga() {
  yield all([authSaga(), userSaga(), questionSaga(), surveySaga() ]);
}

export default rootReducer;