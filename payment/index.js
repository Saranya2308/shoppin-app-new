const express = require('express');
const app = express();
const PORT = process.env.PORT || 3000;

app.get('/', (req, res) => {
    res.send('payment service is running');
});

app.listen(PORT, () => {
    console.log('payment service listening on port', PORT);
});
