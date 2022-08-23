var CopyPlugin = require('copy-webpack-plugin');

var path = require('path');
var fs = require('fs');

module.exports = {
  mode: 'development',
  entry: './src/main/resources/META-INF/resources/app/app.js',
  output: {
    path: path.resolve(__dirname, 'src/main/resources/META-INF/resources/dist'),
    filename: 'app.js'
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
		{ 
			from: 'src/main/resources/META-INF/resources/app/index.js', 
			to: 'dist/index.js',
			transform(content) {
			    return content
			      .toString()
			      .replace('__DIAGRAM_XML__', fs.readFileSync(__dirname + '/src/main/resources/META-INF/resources/bpmn/newDiagram.bpmn', 'utf-8'));
			  },
		},
        { from: '../../../node_modules/bpmn-js/dist/assets', to: 'dist/vendor/bpmn-js/assets' },
        { from: '../../../node_modules/gestione-processi-portlet/node_modules/bpmn-js-properties-panel/dist/assets', to: 'dist/vendor/bpmn-js-properties-panel/assets' },
      ]
    })
  ]
};