module.exports = function(grunt) {

  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    clean: ['modules/gestione-processi/gestione-processi-frontend/src/main/resources/META-INF/resources/libs'],
    browserify: {
      options: {
        browserifyOptions: {
          debug: true,
          list: true,
          // make sure we do not include browser shims unnecessarily
          insertGlobalVars: {
            process: function () {
              return 'undefined';
            },
            Buffer: function () {
              return 'undefined';
            }
          }
        },
        transform: [ 'brfs' ]
      },
      app: {
        files: {
          'modules/gestione-processi/gestione-processi-frontend/src/main/resources/META-INF/resources/dist/index.js': [ 
			'modules/gestione-processi/gestione-processi-frontend/src/main/resources/META-INF/resources/app/**/*.js' 
			]
        }
      }
    },
    copy: {
      diagram_js: {
        files: [
          {
            src: 'node_modules/diagram-js/assets',
            dest: 'modules/gestione-processi/gestione-processi-frontend/src/main/resources/META-INF/resources/dist/css/diagram-js.css'
          }
        ]
      },
      bpmn_js: {
        files: [
          {
            expand: true,
            cwd: 'node_modules/bpmn-js/assets',
            src: ['**/*.*', '!**/*.js'],
            dest: 'modules/gestione-processi/gestione-processi-frontend/src/main/resources/META-INF/resources/dist/vendor'
          }
        ]
      },
      app: {
        files: [
          {
            expand: true,
            cwd: 'modules/gestione-processi/gestione-processi-frontend/src/main/resources/META-INF/resources/app/',
            src: ['**/*.*', '!**/*.js'],
            dest: 'modules/gestione-processi/gestione-processi-frontend/src/main/resources/META-INF/resources/dist'
          }
        ]
      }
    },
    watch: {
      files: ['<%= jshint.files %>'],
      tasks: ['jshint']
    }
  });

  grunt.file.setBase('../../../');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-clean');
  grunt.loadNpmTasks('grunt-contrib-copy');
  grunt.loadNpmTasks('grunt-replace');
  grunt.loadNpmTasks('grunt-browserify');

  grunt.registerTask('test', ['jshint']);

  grunt.registerTask('default', [/*'jshint', */'clean', 'copy', 'browserify:app']);
};