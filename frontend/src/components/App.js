import React, { Fragment } from 'react';
import { Router, Link } from '@reach/router';
import styled from 'styled-components';
import Emoji from './Emoji';
import LandingPage from './LandingPage';
import TrackerPage from './TrackerPage';
import BlankPage from './BlankPage';
import '../App.css';
import 'react-loader-spinner/dist/loader/css/react-spinner-loader.css';

// Custom navigation link, - used to target which link is active to render the active tab.
const NavLink = ({ exact, ...props }) => (
  <Link
    {...props}
    getProps={({ isCurrent, isPartiallyCurrent }) => {
      return {
        className: (exact ? isCurrent : isPartiallyCurrent) ? 'active' : ''
      };
    }}
  />
);

const Navbar = styled.nav`
  position: sticky;
  top: 0;
  background: #eee;
  font-weight: 600;
  z-index: 1;

  & div {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;

    /* Style of items in navbar */
    & ul {
      margin: 0;
      padding: 0;

      & li {
        list-style: none;
        display: inline-block;

        & a {
          display: inline-block;
          color: #000;
          text-decoration: none;
          padding: 1.25rem 1.5rem;

          &.active {
            border-bottom: 2px solid #000;
          }
        }
      }
    }

    & a {
      color: #000;
      text-decoration: none;
      padding: 0rem 1.5rem;
    }
  }
`;

const App = () => (
  <Fragment>
    <Navbar>
      <div className='container'>
        <ul>
          <li>
            <NavLink exact to='/'>
              Profile
            </NavLink>
          </li>
          <li>
            <NavLink to='/tracker'>Tracker</NavLink>
          </li>
        </ul>
        <a
          href='/#'
          onClick={e => {
            e.preventDefault();
            window.open('https://www.youtube.com/watch?v=y90yaLFoYoA');
          }}
        >
          <Emoji symbol='🍺' label='beer' />
        </a>
      </div>
    </Navbar>
    <div className='container'>
      <Router>
        <LandingPage path='/' />
        <BlankPage path='/tracker' />
        <TrackerPage path='/tracker/:userId' />
      </Router>
    </div>
  </Fragment>
);

export default App;
