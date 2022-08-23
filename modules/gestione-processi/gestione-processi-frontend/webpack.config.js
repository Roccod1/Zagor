var CopyPlugin = require('copy-webpack-plugin');

var path = require('path');

module.exports = {
  mode: 'development',
  entry: 'modules/gestione-processi/gestione-processi-frontend/src/main/resources/META-INF/resources/app/index.js',
  output: {
    path: path.resolve(__dirname, 'src/main/resources/META-INF/resources/dist'),
    filename: 'index.js'
  },
  module: {
    rules: [
      {
        test: /\.bpmn$/,
        use: {
          loader: 'raw-loader'
        }
      }
    ]
  },
  plugins: [
    new CopyPlugin({
      patterns: [
        { from: '../../../node_modules/bpmn-js/dist/assets', to: 'modules/gestione-processi/gestione-processi-frontend/src/main/resources/META-INF/resources/dist/vendor/bpmn-js/assets' },
        { from: '../../../node_modules/gestione-processi-portlet/node_modules/bpmn-js-properties-panel/dist/assets', to: 'modules/gestione-processi/gestione-processi-frontend/src/main/resources/META-INF/resources/dist/vendor/bpmn-js-properties-panel/assets' },
      ]
    })
  ]
};