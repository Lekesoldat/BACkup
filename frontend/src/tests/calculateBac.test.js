import calculateBac from '../utils/calculateBac';

test('Test BAC after chugging one bottle of små sure', () => {
  const person = {
  uniqueID: "9820f22d-d94c-45cb-8c53-fbe0b778e9f0",
  name: "Magnus Holtet",
  weight: 85.0,
  gender: "M",
  sessions: [
    {
      "drinks": [
        {
          date: "1573122623112",
          percentage: 21.0,
          volume: 0.7
        }
      ]
    }
  ]}
  expect(calculateBac(person)).toBeLessThanOrEqual(0.10);
  expect(calculateBac(person)).toBeGreaterThanOrEqual(0.08);
});
