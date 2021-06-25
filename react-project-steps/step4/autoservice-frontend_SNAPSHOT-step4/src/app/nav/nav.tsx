import React from 'react';
import './nav.scss';
import {BrowserRouter as Router, Link, Route, Switch,} from "react-router-dom";
import {WelcomePage} from "../pages/welcome/welcom-page";
import {Car} from "../pages/car/car";
import {Master} from "../pages/master/master";
import {Order} from "../pages/order/order";
import {OrderStatus} from "../pages/order-status/order-status";

export const Nav: React.FC<any> = () => {
  return (
      <Router>
        <nav>
          <Link to="/welcome">Welcome</Link>
          <Link to="/car">Cars</Link>
          <Link to="/master">Masters</Link>
          <Link to="/order">Orders</Link>
          <Link to="/order-status">Order Statuses</Link>
        </nav>
        <Switch>
          <Route path="/welcome"><WelcomePage/></Route>
          <Route path="/car"><Car/></Route>
          <Route path="/master"><Master/></Route>
          <Route path="/order"><Order/></Route>
          <Route path="/order-status"><OrderStatus/></Route>
        </Switch>
      </Router>)
}

