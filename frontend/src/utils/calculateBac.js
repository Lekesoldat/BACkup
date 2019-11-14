// A utility for frontend handling of the BAC calculation.
const calculateBac = ({ weight, gender, sessions }) => {
  const session = sessions[sessions.length - 1];
  if (session.drinks.length > 0) {
    const first = session.drinks[0];
    const last = session.drinks[session.drinks.length - 1];
    const elapsedTime = last.date - first.date;

    return (
      (last.volume * last.percentage) /
        (weight * 2.668 * (gender === 'M' ? 0.68 : 0.55)) -
      (elapsedTime / (1000 * 3600)) * 0.015
    );
  }
  return 0;
};

export default calculateBac;
