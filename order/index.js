const express = require('express');
const app = express();
const PORT = process.env.PORT || 3000;

app.get('/', (req, res) => {
    res.send('order service is running');
});

app.listen(PORT, () => {
    console.log('order service listening on port', PORT);
});
