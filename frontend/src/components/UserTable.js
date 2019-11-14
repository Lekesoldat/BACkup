import React from 'react';
import { navigate } from '@reach/router';
import styled from 'styled-components';
import useRequest from '../hooks/useRequest';

const Table = styled.table`
  border: 1px solid black;
  border-collapse: collapse;
`;

const Row = styled.tr`
  &:hover {
    background-color: #e4e4e4;
    cursor: pointer;
  }
`;

const Th = styled.th`
  border: 1px solid black;
  padding: 1rem;
`;

const Td = styled.td`
  text-align: center;
  border: 1px solid black;
  padding: 1rem;
`;

// A component for dynamically rendering users.
const UserTable = ({ data }) => {
  const { request: startSession } = useRequest({
    lazy: true,
    method: 'POST',
    headers: {
      Accept: 'application/json',
      'Content-Type': 'application/json'
    }
  });

  return (
    <>
      <Table>
        <thead>
          <tr>
            <Th>Name</Th>
            <Th>Weight</Th>
            <Th>Gender</Th>
            <Th>Total Sessions</Th>
            <Th>Total Drinks</Th>
            <Th>Average</Th>
          </tr>
        </thead>
        <tbody>
          {data.map(u => {
            return (
              <Row
                key={u.id}
                onClick={async () => {
                  // Start a new drinking session when selecting the user.
                  await startSession({
                    path: `/api/users/${u.id}/session`
                  });

                  // Navigate to the tracker when the session is created.
                  await navigate(`/tracker/${u.id}`);
                }}
              >
                <Td>{u.name}</Td>
                <Td>{u.weight}</Td>
                <Td>{u.gender}</Td>
                <Td>{u.sessions.length}</Td>
                <Td>
                  {u.sessions.reduce(
                    (prev, curr) => prev + curr.drinks.length,
                    0
                  )}
                </Td>
                <Td>
                  {!u.sessions.length
                    ? 0
                    : Math.round(
                        u.sessions.reduce(
                          (prev, curr) => prev + curr.drinks.length,
                          0
                        ) / u.sessions.length
                      )}
                </Td>
              </Row>
            );
          })}
        </tbody>
      </Table>
    </>
  );
};

export default UserTable;
