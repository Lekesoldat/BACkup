import React from 'react';
import styled from 'styled-components';

const Input = styled.input`
  padding: 0.25rem;
  text-align: center;
  border-radius: 0.5rem;
  font-size: 1.25rem;
  font-weight: 180;
  outline: none;
  width: 10rem;

  &[type='text'],
  &[type='number'] {
    display: block;
  }

  margin-top: 0.5rem;
  margin-bottom: 1rem;
`;

const InputField = props => <Input {...props} />;

export default InputField;
