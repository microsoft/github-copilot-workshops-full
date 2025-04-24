import React from 'react';
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer } from 'recharts';
import { Typography, Box } from '@mui/material';

function AvocadoChart({ data }) {
  return (
    <Box>
      <Typography variant="h6" gutterBottom>
        Average Price Over Time
      </Typography>
      <ResponsiveContainer width="100%" height={400}>
        <LineChart data={data}>
          <CartesianGrid strokeDasharray="3 3" />
          <XAxis dataKey="date" />
          <YAxis />
          <Tooltip />
          <Legend />
          <Line type="monotone" dataKey="avgPrice" stroke="#90caf9" name="Average Price" />
        </LineChart>
      </ResponsiveContainer>
    </Box>
  );
}

export default AvocadoChart;
