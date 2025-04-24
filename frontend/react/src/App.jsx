import React, { useEffect, useState } from 'react';
import { Container, Grid, Box, FormControl, InputLabel, Select, MenuItem, Typography } from '@mui/material';
import AvocadoTable from './components/AvocadoTable';
import AvocadoChart from './components/AvocadoChart';

function App() {
  const [data, setData] = useState([]);
  const [filteredData, setFilteredData] = useState([]);
  const [regions, setRegions] = useState([]);
  const [types, setTypes] = useState([]);
  const [selectedRegion, setSelectedRegion] = useState('');
  const [selectedType, setSelectedType] = useState('');

  useEffect(() => {
    fetch('/avocado.csv')
      .then((response) => response.text())
      .then((csvText) => {
        const rows = csvText.split('\n').slice(1); // Skip header row
        const parsedData = rows.map((row) => {
          const [date, avgPrice, totalVolume, region, type] = row.split(',');
          return { date, avgPrice: parseFloat(avgPrice), totalVolume, region, type };
        }).filter(item => !isNaN(item.avgPrice)); // Filter out invalid rows

        setData(parsedData);
        setFilteredData(parsedData);

        // Extract unique regions and types
        const uniqueRegions = [...new Set(parsedData.map((item) => item.region))];
        const uniqueTypes = [...new Set(parsedData.map((item) => item.type))];
        setRegions(uniqueRegions);
        setTypes(uniqueTypes);
      })
      .catch((error) => console.error('Error loading CSV:', error));
  }, []);

  useEffect(() => {
    // Filter data based on selected region and type
    const filtered = data.filter((item) => {
      return (
        (selectedRegion === '' || item.region === selectedRegion) &&
        (selectedType === '' || item.type === selectedType)
      );
    });
    setFilteredData(filtered);
  }, [selectedRegion, selectedType, data]);

  return (
    <Container maxWidth="lg">
      <Box marginBottom={4}>
        <Typography variant="h4" gutterBottom>
          Avocado Dashboard
        </Typography>
      </Box>

      {/* Filters */}
      <Box display="flex" gap={2} marginBottom={4}>
        <FormControl fullWidth>
          <InputLabel>Region</InputLabel>
          <Select
            value={selectedRegion}
            onChange={(e) => setSelectedRegion(e.target.value)}
          >
            <MenuItem value="">All</MenuItem>
            {regions.map((region, index) => (
              <MenuItem key={index} value={region}>
                {region}
              </MenuItem>
            ))}
          </Select>
        </FormControl>

        <FormControl fullWidth>
          <InputLabel>Type</InputLabel>
          <Select
            value={selectedType}
            onChange={(e) => setSelectedType(e.target.value)}
          >
            <MenuItem value="">All</MenuItem>
            {types.map((type, index) => (
              <MenuItem key={index} value={type}>
                {type}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
      </Box>

      {/* Layout */}
      <Grid container spacing={4}>
        <Grid item xs={12} md={6}>
          <AvocadoTable data={filteredData} />
        </Grid>
        <Grid item xs={12} md={6}>
          <AvocadoChart data={filteredData} />
        </Grid>
      </Grid>
    </Container>
  );
}

export default App;
