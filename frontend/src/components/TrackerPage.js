import React, { useRef, useState } from 'react';
import useRequest from '../hooks/useRequest';
import Aligner from './Aligner';
import InputField from './InputField';
import Loader from 'react-loader-spinner';
import styled from 'styled-components';
import moment from 'moment';
import calculateBac from '../utils/calculateBac';

const Container = styled.div`
  padding: 2rem;
`;

const Header = styled.h2`
  font-family: system-ui;
  text-align: center;
`;

const CurrentBac = styled.p`
  font-size: 300%;
  font-family: system-ui;
  color: #b6500e;
  text-align: center;
  margin-top: 0%;
`;

const AddButton = styled.button`
  padding: 0.25rem;
  text-align: center;
  border-radius: 0.5rem;
  font-size: 1.25rem;
  font-weight: 180;
  outline: none;
  background: #c4c4c4;
  width: 10rem;
`;

const TrackerPage = ({ userId }) => {
  // data: user -> renames data to user
  const { loading, data: user, request } = useRequest({
    path: `/api/users/${userId}`
  });

  const bacRef = useRef();

  // Initialize BAC when the user is loaded initially
  if (!bacRef.current && !loading) {
    bacRef.current = calculateBac(user);
  }

  const [volume, setVolume] = useState(0);
  const [percentage, setPercentage] = useState(0);

  const handleAddUnitClick = async () => {
    const drink = {
      date: moment().valueOf(),
      percentage: percentage,
      volume: volume
    };

    const { data: user } = await request({
      path: `/api/users/${userId}/drink`,
      method: 'POST',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(drink)
    });

    bacRef.current += calculateBac(user);
  };

  return (
    <>
      {!user || loading ? (
        <Aligner>
          <Loader type='Triangle' />
        </Aligner>
      ) : (
        <Container>
          <Header>
            BACkup: <span style={{ color: 'red' }}>{user.name}</span>!
          </Header>

          <CurrentBac>{bacRef.current.toFixed(3)}&permil;</CurrentBac>
          <label>
            Volume:
            <InputField
              placeholder='in dl'
              type='number'
              onChange={e => setVolume(e.target.value)}
              step='0.1'
              min='0'
              max='10'
            />
          </label>
          <br />
          <label>
            Percentage:
            <InputField
              placeholder='30,5%'
              type='number'
              onChange={e => setPercentage(e.target.value)}
              step='0.1'
              min='0'
              max='96'
            />
          </label>
          <br />
          <AddButton onClick={handleAddUnitClick}>Add unit</AddButton>
        </Container>
      )}
    </>
  );
};

export default TrackerPage;
