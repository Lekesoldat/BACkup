import { useCallback, useEffect, useState, useRef } from 'react';
import { merge, isEqual } from 'lodash';

const useDeepCompareMemoize = value => {
  const ref = useRef();

  if (!isEqual(ref.current, value)) {
    ref.current = value;
  }

  return ref.current;
};

const useRequest = ({
  path: initialPath = null,
  lazy = false,
  ...restOptions
} = {}) => {
  const initialOptions = useDeepCompareMemoize(restOptions);

  const [state, setState] = useState({
    loading: !lazy,
    error: null,
    data: null
  });

  const request = useCallback(
    async ({ path = initialPath, ...options } = {}) => {
      setState({ loading: true, error: null, data: null });
      const mergedOptions = merge(initialOptions, options);
      const response = await fetch(path, mergedOptions);

      const result = response.ok
        ? { error: null, data: await response.json() }
        : { error: response, data: null };

      setState({ loading: false, ...result });
      return result;
    },
    [initialPath, initialOptions]
  );

  // Initiates a request on component mount if the request is not lazy
  useEffect(() => {
    !lazy && request();
  }, [request, lazy]);

  return { ...state, request };
};

export default useRequest;
