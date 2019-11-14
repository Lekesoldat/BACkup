import React from 'react';

// A component for correctly rendering emojis.
const Emoji = ({ label, symbol }) => (
  <span
    className='emoji'
    role='img'
    aria-label={label ? label : ''}
    aria-hidden={label ? 'false' : 'true'}
  >
    {symbol}
  </span>
);

export default Emoji;
