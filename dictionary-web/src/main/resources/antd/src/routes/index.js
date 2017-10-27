import React, {PropTypes} from 'react';
import {Router, Route, hashHistory} from 'react-router';
import NotFound from 'components/common/NotFound';
import index from 'components/index';

const Routes = () =>
  <Router history={hashHistory}>
    <Route path="/" component={index}/>
    <Route path="*" component={NotFound}/>
  </Router>;

Routes.propTypes = {
  history: PropTypes.any
};

export default Routes;
