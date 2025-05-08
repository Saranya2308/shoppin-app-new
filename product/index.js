const express = require('express');
const app = express();
const PORT = process.env.PORT || 3000;

app.get('/', (req, res) => {
    res.send('product service is running');
});

app.listen(PORT, () => {
    console.log('product service listening on port', PORT);
});
