const express = require('express');
const app = express();
const PORT = process.env.PORT || 3000;

app.get('/', (req, res) => {
    res.send('cart service is running');
});

app.listen(PORT, () => {
    console.log('cart service listening on port', PORT);
});
