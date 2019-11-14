import React from 'react';
import styled from 'styled-components';

const Container = styled.div`
  display: flex;
  height: 100%;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;

// Small component for vertical and horisontal centering.
const Aligner = () => <Container />;

export default Aligner;
