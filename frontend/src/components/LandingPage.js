import React, { useState } from 'react';
import styled from 'styled-components';
import Loader from 'react-loader-spinner';
import InputField from './InputField';
import Aligner from './Aligner';
import UserTable from './UserTable';
import useRequest from '../hooks/useRequest';

const NormalText = styled.p`
  font-family: system-ui;
  font-size: 1.5rem;
`;

const Container = styled.div`
  padding: 2rem;
  font-family: system-ui;
`;

const Header = styled.h2`
  font-family: system-ui;
  text-align: center;
`;

const Label = styled.label`
  display: block;
`;

const Button = styled.button`
  padding: 0.25rem;
  text-align: center;
  border-radius: 0.5rem;
  font-size: 1.25rem;
  font-weight: 180;
  outline: none;
  background: #c4c4c4;
  width: 10rem;
  margin: 2rem 0rem;
`;

const LandingPage = () => {
  const { loading, data: users, request: refetchUsers } = useRequest({
    path: '/api/users'
  });

  const { loading: storingUser, request: storeUser } = useRequest({
    lazy: true,
    path: `/api/users/`,
    method: 'POST',
    headers: {
      Accept: 'application/json',
      'Content-Type': 'application/json'
    }
  });

  const [name, setName] = useState('');
  const [weight, setWeight] = useState(null);
  const [gender, setGender] = useState('');

  const handleCreateProfileClick = async () => {
    // With the input fields, - create a new user object.
    const user = {
      name: name,
      weight: weight,
      gender: gender
    };

    // Store the user on the server and fetch it back.
    await storeUser({
      body: JSON.stringify(user)
    });

    // Re-render the user-table.
    await refetchUsers();
  };

  return (
    <>
      <main>
        <Container>
          <Header>BACkup!</Header>
          <NormalText>New here? Create a profile!</NormalText>
          <Label>
            Name: &ensp; &ensp;
            <InputField
              type='text'
              placeholder="Who's drinking?"
              onChange={e => setName(e.target.value)}
            />
          </Label>
          <Label>
            Weight: &ensp;&nbsp;
            <InputField
              type='number'
              onChange={e => setWeight(e.target.value)}
              min='0'
              placeholder='How heavy?'
            />
          </Label>
          <Label>
            Gender:
            <input
              type='radio'
              onChange={e => setGender('M')}
              value='male'
              checked={gender === 'M'}
            />
            Male
            <input
              type='radio'
              onChange={e => setGender('F')}
              value='female'
              checked={gender === 'F'}
            />
            Female
          </Label>
          <Button onClick={handleCreateProfileClick}>
            Create profile {storingUser && '(Storing users...)'}
          </Button>

          <NormalText>
            Already registered? Click your profile and start a new session!
          </NormalText>
          {loading ? (
            <Aligner>
              <Loader type='CradleLoader' />
            </Aligner>
          ) : (
            <UserTable data={users} />
          )}
        </Container>
      </main>
    </>
  );
};

export default LandingPage;
