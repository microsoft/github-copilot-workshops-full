import React from 'react';
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  Typography,
  Box,
} from '@mui/material';

function AvocadoTable({ data }) {
  return (
    <Box>
      <Typography variant="h6" gutterBottom>
        Avocado Prices Table
      </Typography>
      <TableContainer component={Paper}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>Date</TableCell>
              <TableCell>Average Price</TableCell>
              <TableCell>Total Volume</TableCell>
              <TableCell>Region</TableCell>
              <TableCell>Type</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {data.map((row, index) => (
              <TableRow key={index}>
                <TableCell>{row.date}</TableCell>
                <TableCell>{row.avgPrice}</TableCell>
                <TableCell>{row.totalVolume}</TableCell>
                <TableCell>{row.region}</TableCell>
                <TableCell>{row.type}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </Box>
  );
}

export default AvocadoTable;
