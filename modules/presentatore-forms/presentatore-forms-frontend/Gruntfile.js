module.exports = function(grunt) {

  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    clean: ['dist'],
    concat: {
      options: {
        separator: ';'
      },
      dist: {
        src: [
              'alpaca/customfields/**/*.js',
              '!alpaca/customfields/**/_*.js',
              '!alpaca/customfields/**/_*.txt',
        ],
        dest: 'alpaca/dist/custom-fields.js'
      }
    },
    uglify: {
      options: {
        banner: '/*! <%= pkg.name %> <%= grunt.template.today("dd-mm-yyyy HH:MM:ss") %> */\n'
      },
      dist: {
        files: {
          'alpaca/dist/custom-fields.min.js': ['<%= concat.dist.dest %>']
        }
      }
    },
    jshint: {
      files: ['Gruntfile.js', '../../../target/<%= pkg.name %>/js/custom-fields/**/*.js'],
      options: {
        // options here to override JSHint defaults
      }
    },
    /*replace: {
        dist: {
          options: {
            patterns: [
              {
                match: 'customFieldDataSource',
                replacement: process.env.customFieldDataSource
              }
            ]
          },
          files: [
            {
            	src: ['<%= concat.dist.dest %>'],
            	dest: '<%= concat.dist.dest %>'
            }
          ]
        }
    },*/
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
  grunt.loadNpmTasks('grunt-replace');

  grunt.registerTask('test', ['jshint']);

  grunt.registerTask('default', [/*'jshint', */'clean', 'concat', /*'replace',*/ 'uglify']);
};